package rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.indexing.handlers;

import java.io.File;

import rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.model.IndexUnit;
import rs.ac.uns.ftn.informatika.udd.vezbe04.lucene.model.IndexUnitBook;

public abstract class DocumentBookHandler {
	public abstract IndexUnitBook getIndexUnit(File file);
	public abstract String getText(File file);
}
