package com.example.tracker_domain.usecase


import com.example.tracker_domain.model.TrackedFood
import com.example.tracker_domain.repository.TrackerRepository


class DeleteTrackedFood(
    private val repository: TrackerRepository
) {

    suspend operator fun invoke(trackedFood: TrackedFood) {
        repository.deleteTrackedFood(trackedFood)
    }
}