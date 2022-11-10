package com.example.tracker_data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tracker_data.local.dao.TrackerDao
import com.example.tracker_data.local.entities.TrackedFoodEntity

@Database(
    entities = [TrackedFoodEntity::class],
    version = 1
)
abstract class TrackerDatabase: RoomDatabase() {

    abstract val dao: TrackerDao
}