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

package ca.simplegames.micro;

/**
 * @author <a href="mailto:florin.patrascu@gmail.com">Florin T.PATRASCU</a>
 * @since $Revision$ (created: 2012-12-19 11:18 AM)
 */
public class Globals {
    public static final String VERSION = "0.1";
    public static final String EMPTY_STRING = "";
    public static final String MICRO = "micro_";
    public static final String UTF8 = "UTF-8";

    public static final String SERVLET_CONTEXT = MICRO + "servlet_context";
    public static final String SERVLET_PATH_NAME = MICRO + "servlet_path_name";
    public static final String SERVLET_PATH = MICRO + "servlet_path";
    public static final String WEB_INF_PATH = MICRO + "web_inf_path";
    public static final String MICRO_CONFIG_PATH = MICRO + "config_path";
    public static final String MICRO_CACHE_MANAGER = MICRO + "cache_manager";

    public static final String MICRO_SITE = MICRO + "site";
    public static final String SCRIPT_CONTROLLERS_CACHE_NAME = MICRO + "script_controllers_cache";
    public static final String MICRO_CACHE_CONFIG = MICRO_CACHE_MANAGER + "_config";
    public static final String MICRO_HELPERS_CONFIG = "helpers";

    public static final String RACK_INPUT = MICRO + "rack_input";
    public static final String SCRIPT_CONTROLLER_RESPONSE = MICRO + "script_controller_response";
    public static final String LOCALE = "locale";
    public static final String DEFAULT_VELOCITY_GLOBAL_LIBRARY_PATH = "ca/simplegames/micro/viewers/velocity/VM_global_library.vm";
    public static final String MICRO_REPOSITORY_MANAGER = MICRO + "repository_manager";

    public static final String PATH_INFO="pathInfo";
    public static final String PATH = "path";
    public static final String REQUEST = "request";
    public static final String RESPONSE = "response";
    public static final String SITE = "site";
    public static final String LOG = "log";
    public static final String CONTEXT = "context";
    public static final String RACK_RESPONSE = "rack_response";
    public static final String TEMPLATE = "template";
    public static final String PARAMETERS="parameters";
    public static final String VIEW = "view";
    public static final String CONTROLLERS = "controllers";
    public static final String YML_EXTENSION=".yml";
    public static final String DEFAULT_REPOSITORY_CONFIG_PATH_NAME="config";
}
