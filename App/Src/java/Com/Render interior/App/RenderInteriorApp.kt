package com.renderinterior.app

import android.app.Application
import com.renderinterior.app.data.TokenManager
import com.renderinterior.app.data.api.ApiClient
import com.renderinterior.app.data.repository.AuthRepository
import com.renderinterior.app.data.repository.CatalogRepository
import com.renderinterior.app.data.repository.ProjectRepository
import com.renderinterior.app.data.repository.RenderRepository

/**
 * Container dependency manual (bukan Hilt/Dagger) -- cukup untuk skala MVP.
 * Semua ViewModel mengambil repository dari sini lewat ViewModelFactory
 * masing-masing (lihat ui/navigation/NavGraph.kt).
 */
class RenderInteriorApp : Application() {

    lateinit var tokenManager: TokenManager
        private set
    lateinit var authRepository: AuthRepository
        private set
    lateinit var projectRepository: ProjectRepository
        private set
    lateinit var renderRepository: RenderRepository
        private set
    lateinit var catalogRepository: CatalogRepository
        private set

    override fun onCreate() {
        super.onCreate()

        tokenManager = TokenManager(this)
        val apiService = ApiClient.create(tokenManager)

        authRepository = AuthRepository(apiService, tokenManager)
        projectRepository = ProjectRepository(apiService)
        renderRepository = RenderRepository(apiService)
        catalogRepository = CatalogRepository(apiService)
    }
}
