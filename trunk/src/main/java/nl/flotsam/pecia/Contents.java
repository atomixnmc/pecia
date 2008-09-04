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
 * A general interface, allowing you to produce several non-inline document
 * elements.
 * 
 * @author Wilfred Springer
 * 
 * @param <V>
 *            The type of the parent document element.
 */
public interface Contents<V> {

    /**
     * Adds a paragraph.
     * 
     * @return The paragraph added.
     */
    Para<? extends V> para();

    /**
     * Adds a paragraph ({@link Para}) containing the text passed in.
     * 
     * @param text
     *            The text to be added to the paragraph.
     * @return The current element.
     */
    V para(String text);

    /**
     * Adds verbatim content.
     * 
     * @return The object representing verbatim content.
     */
    Verbatim<? extends V> verbatim();

    /**
     * Adds a new section.
     * 
     * @param title
     *            The title of the section.
     * @return The section just created.
     */
    AnnotatedSection<? extends V> section(String title);

    /**
     * Adds an itemized list.
     * 
     * @return The itemized list just created.
     */
    ItemizedList<? extends V> itemizedList();

    /**
     * Adds an ordered list.
     * 
     * @return The ordered list just created.
     */
    ItemizedList<? extends V> orderedList();

    /**
     * Adds a two-column table.
     * 
     * @return A two column table.
     */
    Table2Cols<? extends V> table2Cols();

    /**
     * Adds a three-column table.
     * 
     * @return A three column table.
     */
    Table3Cols<? extends V> table3Cols();

    /**
     * Adds a four-column table.
     * 
     * @return A four column table.
     */
    Table4Cols<? extends V> table4Cols();

    /**
     * Adds a five-column table.
     * 
     * @return A five column table.
     */
    Table5Cols<? extends V> table5Cols();

}
