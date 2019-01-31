package ink.moshuier.motse.rule.utils

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import ink.moshuier.motse.rule.table.TaskTable
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.db.*
import org.jetbrains.anko.info

//调用父类构造函数时判断数据库是不是升级,决定是否调用onUpdate函数
class DBHelper private constructor(c: Context ):ManagedSQLiteOpenHelper(c,"motserule",null,1),AnkoLogger{
    companion object {
        private var helper: DBHelper? = null
    @Synchronized
        fun getInstance(ctx:Context): DBHelper?{
            return helper
                ?: DBHelper(ctx.applicationContext)
        }
    }
    //第一次安装时候调用,将来覆盖,更新应用只调用update
    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(TaskTable.TABLE_NAME,true,
            TaskTable.ID to INTEGER + PRIMARY_KEY + UNIQUE ,
            TaskTable.TITLE to TEXT,
            TaskTable.WEIGHT to INTEGER)
        println("db create")
        info("db created")
    }
    //新版本在原来数据库文件基础上更新表结构
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        println("db upgrade")
    }
}
//In addition, we create an extension property for the context, so that any class that requires Context can access the database directly.
//可以使用默认reciever调用applicationContext
    val Context.database: DBHelper?
        get() = DBHelper.getInstance(applicationContext)


