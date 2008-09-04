package nl.flotsam.pecia.builder.base;

import nl.flotsam.pecia.builder.DocumentBuilder;
import nl.flotsam.pecia.builder.base.AbstractTableBuilder;
import nl.flotsam.pecia.builder.base.LifecycleListener;

import junit.framework.TestCase;

public class AbstractTableBuilderTest extends TestCase {

    public void testStateTransition() {
        TableBuilderImpl<Object> builder = new TableBuilderImpl<Object>(null, null, null);
        assertTrue(builder.proceed(true));
        assertFalse(builder.proceed(true));
        assertFalse(builder.proceed(true));
        assertTrue(builder.proceed(false));
        assertFalse(builder.proceed(false));
        try {
            builder.proceed(true);
            fail("Expected exception");
        } catch(IllegalStateException ise) {
            // This is ok.
        }
    }

    public void testNoHeader() {
        TableBuilderImpl<Object> builder = new TableBuilderImpl<Object>(null, null, null);
        assertTrue(builder.proceed(false));
    }

    private static class TableBuilderImpl<T> extends AbstractTableBuilder<T> {

        public TableBuilderImpl(DocumentBuilder builder, T parent, LifecycleListener listener) {
            super(builder, parent, listener);
        }

        public int getColCount() {
            return 0;
        }

    }

}
