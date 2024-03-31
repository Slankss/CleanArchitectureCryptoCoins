package com.okankkl.cleanarchitecturecryptocoins.domain.use_case.get_coins
import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.okankkl.cleanarchitecturecryptocoins.common.Resource
import com.okankkl.cleanarchitecturecryptocoins.data.remote.dto.toCoin
import com.okankkl.cleanarchitecturecryptocoins.domain.model.Coin
import com.okankkl.cleanarchitecturecryptocoins.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject
class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(data = coins))
        } catch (e: HttpException){
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occured"))
        } catch (e : IOException){
            emit(Resource.Error(message = "Couldn't reach server. Check your internet connection"))
        }
    }
}