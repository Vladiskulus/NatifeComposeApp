package ua.vn.iambulance.natifeapp.domain

import ua.vn.iambulance.natifeapp.data.GiphyRepository
import ua.vn.iambulance.natifeapp.data.entity.GiphyData

class GetGiphyUseCase(private val giphyRepository: GiphyRepository) {
    suspend operator fun invoke():List<GiphyData>{
        return giphyRepository.getGiphy()
    }
}