package com.hmzeda.newsdemo.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dagger.hilt.android.qualifiers.ApplicationContext
import net.sqlcipher.database.SupportFactory

@Database(entities = [], version = 1, exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class DemoDatabase : RoomDatabase() {

    companion object{
        var instance : DemoDatabase?=null
        private val dataBaseName:String="db-demo"

        private fun createDataBase(context: Context):DemoDatabase{
            // here our pass phrase is hardcoded just because its a demo app. however
            // passPhrase contain a hash of some data related to our app to make our data base secure
            val factory = SupportFactory("passphrase".toByteArray())
            return Room.databaseBuilder(context,DemoDatabase::class.java,dataBaseName)
                .openHelperFactory(factory)
                .fallbackToDestructiveMigration()
                .build()
        }

        @Synchronized
        fun getInstance(@ApplicationContext context: Context): DemoDatabase? {
            if (instance==null){
                synchronized(DemoDatabase::class.java){
                    instance=createDataBase(context)
                }
            }
            return instance
        }
    }


}