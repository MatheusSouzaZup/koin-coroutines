package com.example.koincorountines.ui.movies

import androidx.lifecycle.Observer
import com.example.koincorountines.R
import com.example.koincorountines.databinding.FragmentMoviesBinding
import com.example.koincorountines.model.Movie
import com.example.koincorountines.model.MoviesPresentation
import com.example.koincorountines.ui.BaseFragment
import com.example.koincorountines.viewmodel.MoviesViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.android.viewmodel.ext.android.viewModel

class MoviesFragment : BaseFragment<FragmentMoviesBinding>() {
    override val fragmentLayout: Int = R.layout.fragment_movies
    private val moviesViewModel: MoviesViewModel by viewModel()

    companion object {
        fun newInstance(): MoviesFragment {
            return MoviesFragment()
        }
    }

    override fun init() {
        observeData()
        moviesViewModel.getMovies()
    }

    private fun observeData() {
        moviesViewModel.screen.observe(this, Observer {
            when (it) {
                is MoviesViewModel.Screen.ShowError -> showError(it.error)
                is MoviesViewModel.Screen.ShowData -> showData(it.moviesPresentation)
            }
        })
    }

    private fun showData(moviesPresentation: MoviesPresentation) {
        bind.rvUpComing.adapter = MovieAdapter(moviesPresentation.upComing)
        bind.rvTopRated.adapter = MovieAdapter(moviesPresentation.topRated)
        bind.rvPopular.adapter = MovieAdapter(moviesPresentation.populars)
    }

    private fun showError(error: Int) {
        Snackbar.make(bind.clRoot, getString(error), Snackbar.LENGTH_LONG).show()
    }

}