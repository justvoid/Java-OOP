package net.ukr.just_void;

import java.io.IOException;

public interface GroupDAO {
	void saveGroup(Group g) throws IOException;

	Group loadGroup(String id) throws IOException;
}
