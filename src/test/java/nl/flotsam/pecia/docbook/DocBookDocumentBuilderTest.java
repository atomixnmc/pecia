package nl.flotsam.pecia.docbook;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import nl.flotsam.pecia.builder.ArticleDocument;
import nl.flotsam.pecia.builder.base.DefaultArticleDocument;
import nl.flotsam.pecia.builder.docbook.DocBookDocumentBuilder;
import nl.flotsam.pecia.builder.xml.StreamingXmlWriter;
import nl.flotsam.pecia.builder.xml.XmlWriter;

import junit.framework.TestCase;

import com.ctc.wstx.stax.WstxOutputFactory;

public class DocBookDocumentBuilderTest extends TestCase {

    private ArticleDocument doc;

    public void setUp() throws XMLStreamException {
        WstxOutputFactory factory = new WstxOutputFactory();
        XMLStreamWriter target = factory.createXMLStreamWriter(System.out);
        XmlWriter writer = new StreamingXmlWriter(target);
        DocBookDocumentBuilder builder = new DocBookDocumentBuilder(writer);
        doc = new DefaultArticleDocument(builder, "Whatever");
    }

    public void testWithPara() {
        System.out.println();
        doc.para().text("whatever").end().end();
    }

    public void testWithTables() {
        System.out.println();
        doc.table2Cols()
            .row()
                .entry().para().text("foo").end()
                .entry().para().text("bar").end()
            .end()
          .end()
       .end();
    }

    public void testWithSections() {
        System.out.println();
        doc
            .section("Whatever")
                .mark("whatever")
                .para()
                    .text("Whatever")
                .end()
            .end()
       .end();
    }

    public void testWithFootnote() {
        System.out.println();
        doc
            .para()
                .text("whatever")
                .footnote()
                    .para()
                        .text("I don't know")
                    .end()
                .end()
            .end()
        .end();
    }

    public void testWithAuthorData() {
        System.out.println();
        doc
            .author()
                .firstname("Wilfred")
                .surname("Springer")
            .end()
            .para()
                .text("Showing author metadata.")
            .end()
        .end();
    }

}
