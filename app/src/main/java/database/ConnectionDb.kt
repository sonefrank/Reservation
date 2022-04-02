package database

import java.sql.Connection
import java.sql.DriverManager

class ConnectionDb {
    var connection: Connection? = null

    fun ConnectionDb(): Connection? {
        try {
            Class.forName("org.postgresql.Driver")
            connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/mytransactiondb",
                "postgres",
                "root"
            )
        } catch (err: Exception) {
            System.err.println(err.message)
        }
        return connection
    }

    @Throws(Exception::class)
    protected fun close_connection(con: Connection) {
        con.close()
    }
}