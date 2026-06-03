
    /**
     * Database configuration is now fully externalized.
     *
     * Values are resolved from environment variables which can be
     * populated from Azure App Configuration / Key Vault using
     * the hosting environment's configuration system.
     */

    private static String getEnvOrDefault(String key, String defaultValue) {
        String value = System.getenv(key);
        return (value == null || value.isEmpty()) ? defaultValue : value;
    }

    // Driver class name
    public static final String DRIVER_NAME = getEnvOrDefault("DB_DRIVER", "org.postgresql.Driver");

    // Host, port and database name
    public static final String DB_HOST = getEnvOrDefault("DB_HOST", "localhost");
    public static final String DB_PORT = getEnvOrDefault("DB_PORT", "5432");
    public static final String DB_NAME = getEnvOrDefault("DB_NAME", "bookstore");

    // Credentials – expected to be supplied via Azure Key Vault / App Configuration
    public static final String DB_USER_NAME = getEnvOrDefault("DB_USERNAME", "bookstore_user");
    public static final String DB_PASSWORD = getEnvOrDefault("DB_PASSWORD", "change_me");

    /**
     * JDBC connection string. For PostgreSQL this is of the form:
     * jdbc:postgresql://host:port/db
     *
     * The port is no longer hard coded and can be overridden per environment
     * using the DB_PORT environment variable.
     */
    public static final String CONNECTION_STRING =
            getEnvOrDefault("DB_CONNECTION_STRING",
                    "jdbc:postgresql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME);
    public final static String DB_HOST = prop.getProperty("db.host");
    public final static String DB_PORT = prop.getProperty("db.port");
    public final static String DB_NAME = prop.getProperty("db.name");
    public final static String DB_USER_NAME = prop.getProperty("db.username");
    public final static String DB_PASSWORD = prop.getProperty("db.password");
    public final static String CONNECTION_STRING = DB_HOST + ":" + DB_PORT + "/" + DB_NAME;

}
