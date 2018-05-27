package lorence.construction.data;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */
public class DatabaseInfo {

    // Database version
    public static final int DB_VERSION = 1;

    // Database name
    public static final String DB_NAME = "vogo";

    // Table Listing
    public static class Tables {
        public static final String Listing = "listing";
        public static final String Concrete = "concrete";
        public static final String Steel = "steel";
    }

    public static class Listing {
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_IMAGE = "image";
    }

    public static class Concrete {
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_VALUE = "value";
    }

    public static class Steel {
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_VALUE = "value";
    }
}
