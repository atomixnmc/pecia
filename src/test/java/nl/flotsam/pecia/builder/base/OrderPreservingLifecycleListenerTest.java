package nl.flotsam.pecia.builder.base;

import nl.flotsam.pecia.DocumentElement;
import nl.flotsam.pecia.builder.base.OrderPreservingLifecycleListener;

import org.easymock.EasyMock;


import junit.framework.TestCase;

public class OrderPreservingLifecycleListenerTest extends TestCase {

    private DocumentElement root;

    private DocumentElement child;

    private DocumentElement nestedChild;

    private DocumentElement siblingNestedChild;

    private DocumentElement siblingChild;

    public void setUp() {
        root = EasyMock.createMock(DocumentElement.class);
        child = EasyMock.createMock(DocumentElement.class);
        nestedChild = EasyMock.createMock(DocumentElement.class);
        siblingNestedChild = EasyMock.createMock(DocumentElement.class);
        siblingChild = EasyMock.createMock(DocumentElement.class);
    }

    public void testHappyPath() {
        OrderPreservingLifecycleListener listener = new OrderPreservingLifecycleListener();
        
        // Only while popping the root element
        EasyMock.expect(root.getParent()).andReturn(null).times(1);
        
        // Both when pushing and popping the element.
        EasyMock.expect(child.getParent()).andReturn(root).times(2);
        EasyMock.expect(nestedChild.getParent()).andReturn(child).times(2);
        
        EasyMock.replay(root, child, nestedChild, siblingNestedChild);
        
        listener.started(root);
        listener.started(child);
        listener.started(nestedChild);
        listener.ended(nestedChild);
        listener.ended(child);
        listener.ended(root);
        
        EasyMock.verify(root, child, nestedChild, siblingNestedChild);
    }
}
