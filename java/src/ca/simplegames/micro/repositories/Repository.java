/*
 * Copyright (c)2012. Florin T.PATRASCU
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ca.simplegames.micro.repositories;

import ca.simplegames.micro.Globals;
import ca.simplegames.micro.MicroContext;
import ca.simplegames.micro.SiteContext;
import ca.simplegames.micro.View;
import ca.simplegames.micro.cache.MicroCache;
import ca.simplegames.micro.utils.CollectionUtils;
import ca.simplegames.micro.utils.IO;
import ca.simplegames.micro.utils.PathUtilities;
import ca.simplegames.micro.utils.StringUtils;
import ca.simplegames.micro.viewers.ViewRenderer;
import org.jrack.utils.ClassUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * A Repository is responsible for identifying resources in a given folder and it can be used
 * as a context helper for accessing a specific resource, rendered or not
 *
 * @author <a href="mailto:florin.patrascu@gmail.com">Florin T.PATRASCU</a>
 * @since $Revision$ (created: 2012-12-20 1:58 PM)
 */
public abstract class Repository {
    private Logger log;

    private String name;
    private MicroCache cache;
    private SiteContext site;
    private String pathName;
    private File path;
    private ViewRenderer renderer;
    private File config;
    private boolean isDefault;

    protected Repository(String name, MicroCache cache, SiteContext site, String pathName, String configPathName) {
        this.name = name;
        log = LoggerFactory.getLogger("Repository::" + name.toUpperCase());

        this.cache = cache;
        this.site = site;

        this.pathName = pathName;
        path = new File(pathName);
        if (!path.exists()) {
            path = new File(site.getWebInfPath(), pathName);
        }

        if (path.exists()) {

            if (configPathName != null) {
                config = new File(path, configPathName);
            }

            // Initialize the View renderer
            Map<String, Object> rendererConfig = (Map<String, Object>) site.getAppConfig().get("renderer");
            String rendererClass = "ca.simplegames.micro.viewers.velocity.VelocityViewRenderer";

            if (!CollectionUtils.isEmpty(rendererConfig)) {
                rendererClass = StringUtils.defaultString(rendererConfig.get("class"), rendererClass);
            }
            try {

                renderer = (ViewRenderer) ClassUtilities.loadClass(rendererClass).newInstance();
                renderer.setRepository(this);
                rendererConfig.put("micro.site", site);
                renderer.loadConfiguration(rendererConfig);

                log.info(String.format("aka: '%s', on: %s", name, path.getAbsolutePath()));
                if (config!= null && config.exists() && config.isDirectory()) {
                    log.info(String.format("config: '%s'", config.getAbsolutePath()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            log.error(String.format("You defined a repository: '%s' on: %s, but there is no content at that path; %s",
                    name, pathName, path.getAbsolutePath()));
        }
        //
    }

    public File getPath() {
        return path;
    }

    public abstract InputStream getInputStream(String name);

    public MicroCache getCache() {
        return cache;
    }

    public void setRenderer(ViewRenderer renderer) {
        this.renderer = renderer;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public SiteContext getSite() {
        return site;
    }

    public Logger getLog() {
        return log;
    }

    public String getName() {
        return name;
    }

    public String getPathName() {
        return pathName;
    }

    public RepositoryWrapper getRepositoryWrapper(MicroContext context) {
        return new RepositoryWrapper(this, context);
    }

    public ViewRenderer getRenderer() {
        return renderer;
    }

    public long getLastModified(String name) {
        return pathToFile(name).lastModified();
    }

    public File pathToFile(String name) {
        return new File(getPath(), name);
    }

    public String read(String path) throws Exception {
        String content = null;

        if (path != null) {
            final File file = pathToFile(path);

            if (cache != null) {
                content = (String) cache.get(file.getAbsolutePath());
            }

            if (content == null) {
                final Reader reader = new InputStreamReader(new FileInputStream(file),
                        Charset.forName(Globals.UTF8));

                content = IO.getString(reader);
                if (cache != null) {
                    cache.put(file.getAbsolutePath(), content);
                }
            }
        }
        return content;
    }

    public void callControllersForPath(String path, MicroContext context) {

    }

    public View getView(String name) {
        if (config != null) {
            File view = new File(config, PathUtilities.extractViewPath(name) + Globals.YML_EXTENSION);
            if (view.exists()) {
                try {
                    return new View((Map) new Yaml().load(new FileInputStream(view)));
                } catch (FileNotFoundException e) {
                    log.error("cannot load the configuration from: " + name);
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}