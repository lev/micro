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
 * A Filter will be invoked every time Micro is receiving a call from Rack
 * The Filter can also be mapped on a specific route.
 * <p/>
 * There are two types of Filters:
 * - before: acting before any other Micro Controllers can act
 * - after: acting after Micro finished processing the response
 *
 * @author <a href="mailto:florin.patrascu@gmail.com">Florin T.PATRASCU</a>
 * @since $Revision$ (created: 2013.01.13 11:17 PM)
 */
public interface Filter {

    /**
     * @return true if this filter must be invoked before the call
     */
    public boolean isBefore();

    /**
     * @return true if this filter must be invoked after the call
     */
    public boolean isAfter();

    /**
     * executed on every request
     *
     * @param context the Micro context
     * @throws Exception
     */
    public void call(MicroContext context) throws Exception;
}
