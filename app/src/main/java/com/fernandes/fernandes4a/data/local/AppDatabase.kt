package com.fernandes.fernandes4a.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fernandes.fernandes4a.data.local.models.UserLocal

@Database(entities = arrayOf(
    UserLocal::class
), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun DatabaseDao(): DatabaseDao
}
/*this.firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task: Task<AuthResult> ->
    if (task.isSuccessful) {
        //Registration OK
        val firebaseUser = this.firebaseAuth.currentUser!!
    } else {
        //Registration error
    }
}*/