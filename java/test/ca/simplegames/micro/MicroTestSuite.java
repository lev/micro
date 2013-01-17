/*
 * Copyright (c)2013 Florin T.Pătraşcu
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

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Micro test suite. Add your tests here, pay attention to the order you execute the tests in the suite.
 *
 * @author <a href="mailto:florin.patrascu@gmail.com">Florin T.PATRASCU</a>
 * @since $Revision$ (created: 2013-01-16 9:01 PM)
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({MicroGenericTest.class, FiltersTest.class})
//@RunWith(OrderedRunner.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class MicroTestSuite {
}