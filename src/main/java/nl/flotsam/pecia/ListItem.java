/*
 * Copyright 2008 the original author or authors.
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

package nl.flotsam.pecia;

/**
 * A document element representing a list item.
 *
 * @author Wilfred Springer
 *
 * @param <T>
 *            The type of the container parent element.
 */
public interface ListItem<T> extends DocumentElement<T> {

	/**
	 * Constructs a new paragraph inside of the list item.
	 *
	 * @return The new paragraph, embedded in the list item.
	 */
	Para<? extends ListItem<T>> para();

}
