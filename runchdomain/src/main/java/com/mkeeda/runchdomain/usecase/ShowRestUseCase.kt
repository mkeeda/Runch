package com.mkeeda.runchdomain.usecase

import com.mkeeda.runchdomain.entity.ImageUrl
import com.mkeeda.runchdomain.entity.RestCardViewEntity
import com.mkeeda.runchdomain.repository.RestSearchRepository

class ShowRestUseCase(
    private val restSearchRepository: RestSearchRepository
) {
    suspend fun randomSelectedRestsByLocation(latitude: Double, longitude: Double, order: Int): List<RestCardViewEntity> {
        val randomSelectedRests = restSearchRepository
            .retrieveByLocation(latitude = latitude, longitude = longitude)
            .rest
            .shuffled()
            .let {
                if (it.size >= order) {
                    it.subList(fromIndex = 0, toIndex = order - 1)
                } else {
                    it
                }
            }
        return randomSelectedRests.map {
            RestCardViewEntity(
                id = it.id,
                name = it.name,
                access = it.access.walk,
                category = it.category,
                imageUrl = getThumbnailUrl(imageUrl = it.image_url)
            )
        }
    }

    // shop_image1 > shop_image2 > null の順で取り出す
    private fun getThumbnailUrl(imageUrl: ImageUrl): String? {
        return when {
            imageUrl.shop_image1.isNotEmpty() -> imageUrl.shop_image1
            imageUrl.shop_image2.isNotEmpty() -> imageUrl.shop_image2
            else -> null
        }
    }
}
