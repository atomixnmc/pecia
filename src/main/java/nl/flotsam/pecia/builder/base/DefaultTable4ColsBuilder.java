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
import nl.flotsam.pecia.LastEntry;
import nl.flotsam.pecia.Row;
import nl.flotsam.pecia.Table4Cols;
import nl.flotsam.pecia.builder.DocumentBuilder;
import nl.flotsam.pecia.builder.Table4ColsBuilder;

public class DefaultTable4ColsBuilder<T> extends AbstractTableBuilder<T> implements Table4ColsBuilder<T> {

    public DefaultTable4ColsBuilder(DocumentBuilder builder, T parent, LifecycleListener listener) {
        super(builder, parent, listener);
    }

    public Row<Entry<Entry<Entry<LastEntry<Table4Cols<T>>>>>> header() {
        return RowFactory.start((Table4Cols<T>) this, getBuilder(), true)
        .col().col().col().create(proceed(true));
    }

    public Row<Entry<Entry<Entry<LastEntry<Table4Cols<T>>>>>> row() {
        return RowFactory.start((Table4Cols<T>) this, getBuilder(), false)
        .col().col().col().create(proceed(false));
    }

    public Table4ColsBuilder<T> start() {
        getListener().started(this);
        return this;
    }

    public int getColCount() {
        return 4;
    }

}
