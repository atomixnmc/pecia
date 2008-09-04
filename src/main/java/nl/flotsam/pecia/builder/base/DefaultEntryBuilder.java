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

package nl.flotsam.pecia.builder.base;

import nl.flotsam.pecia.Entry;
import nl.flotsam.pecia.Para;
import nl.flotsam.pecia.builder.DocumentBuilder;
import nl.flotsam.pecia.builder.EntryBuilder;
import nl.flotsam.pecia.builder.Initializer;

public class DefaultEntryBuilder<T> extends AbstractBuilder<T> implements
        EntryBuilder<T> {

    private boolean header;

    public DefaultEntryBuilder(DocumentBuilder builder, T parent, boolean header,
            LifecycleListener listener) {
        super(builder, parent, listener);
        this.header = header;
    }

    public T entry() {
        T parent = getParent();
        if (parent instanceof Initializer) {
            ((Initializer) parent).start();
        }
        return parent;
    }

    public Para<? extends Entry<T>> para() {
        return getBuilder().createPara(this, getBuilder()).start();
    }

    public boolean isHeader() {
        return header;
    }

    public EntryBuilder<T> start() {
        getListener().started(this);
        return this;
    }

    public Entry<T> para(String text) {
        getBuilder().createPara(this, getBuilder()).text(text).end();
        return this;
    }

}
