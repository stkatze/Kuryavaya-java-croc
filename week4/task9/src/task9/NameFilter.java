package task9;

import java.io.File;
import java.io.FilenameFilter;

public class NameFilter implements FilenameFilter {
	private String ext;

	public NameFilter(String ext) {
		this.ext = ext.toLowerCase();
	}

	@Override
	public boolean accept(File dir, String name) {
		return name.toLowerCase().endsWith(ext);
	}

}
