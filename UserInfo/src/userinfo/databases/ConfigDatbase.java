package userinfo.databases;

public class ConfigDatbase {
    private static String nameDatabaseManagementSystem;
    private ConfigDatbase(){
        nameDatabaseManagementSystem="Postgresql";
    }
    public static String getNameDatabaseManagementSystem(){
        if(null==nameDatabaseManagementSystem){
            new ConfigDatbase();
        }
        return nameDatabaseManagementSystem;
    }
}
