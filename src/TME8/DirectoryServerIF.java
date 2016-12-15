package TME8;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

@Remote
public interface DirectoryServerIF {
	public List<DirectoryEntry> listEntries(String nom) throws DirectoryEntryException;
	public List<DirectoryEntry> listAllEntries();
	public void addEntry(String nom, String mail) throws DirectoryEntryException;
	public void removeEntry(String nom, String mail) throws DirectoryEntryException;
	public void removeEntries(String nom) throws DirectoryEntryException;
}
