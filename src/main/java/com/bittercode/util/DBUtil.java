
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
    private static HikariDataSource dataSource;
            Class.forName(DatabaseConfig.DRIVER_NAME);

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(DatabaseConfig.CONNECTION_STRING);
            config.setUsername(DatabaseConfig.DB_USER_NAME);
            config.setPassword(DatabaseConfig.DB_PASSWORD);

            // Azure-friendly pool and timeout settings
            config.setMaximumPoolSize(10);
            config.setConnectionTimeout(30000); // 30 seconds
            config.setIdleTimeout(600000); // 10 minutes
            config.setMaxLifetime(1800000); // 30 minutes

            dataSource = new HikariDataSource(config);
    public static Connection getConnection() throws StoreException {

        if (dataSource == null) {
            throw new StoreException(ResponseCode.DATABASE_CONNECTION_FAILURE);
        }

        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new StoreException(ResponseCode.DATABASE_CONNECTION_FAILURE, e);
        }
            throw new StoreException(ResponseCode.DATABASE_CONNECTION_FAILURE, e);
        }
            throw new StoreException(ResponseCode.DATABASE_CONNECTION_FAILURE, e);
        }
            throw new StoreException(ResponseCode.DATABASE_CONNECTION_FAILURE, e);
        }
    }// End of static block

    public static Connection getConnection() throws StoreException {

        if (connection == null) {
            throw new StoreException(ResponseCode.DATABASE_CONNECTION_FAILURE);
        }

        return connection;
    }

}
