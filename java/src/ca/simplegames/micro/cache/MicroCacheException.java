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

package ca.simplegames.micro.cache;

/**
 * MicroCacheException
 *
 * @author <a href="mailto:florin.patrascu@gmail.com">Florin T.PATRASCU</a>
 * @since $Revision$ (created: 2012-12-19 4:24 PM)
 */
public class MicroCacheException extends Exception {
    /**
     * Constructor for MicroCacheException.
     */
    public MicroCacheException() {
        super();
    }

    /**
     * Constructor for MicroCacheException.
     *
     * @param message
     */
    public MicroCacheException(String message) {
        super(message);
    }

    /**
     * Constructor for MicroCacheException.
     *
     * @param message
     * @param cause
     */
    public MicroCacheException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor for MicroCacheException.
     *
     * @param cause
     */
    public MicroCacheException(Throwable cause) {
        super(cause);
    }
}
