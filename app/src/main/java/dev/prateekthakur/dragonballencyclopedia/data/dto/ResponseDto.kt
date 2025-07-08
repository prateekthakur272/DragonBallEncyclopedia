package dev.prateekthakur.dragonballencyclopedia.data.dto

data class ResponseDto<T>(
    val items: List<T>,
)
