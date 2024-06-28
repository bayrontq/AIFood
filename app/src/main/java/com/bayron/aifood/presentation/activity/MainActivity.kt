package com.bayron.aifood.presentation.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.bayron.aifood.R
import com.bayron.aifood.data.preferences.DataStoreRepositoryImpl
import com.bayron.aifood.databinding.ActivityMainBinding
import com.bayron.aifood.presentation.viewmodel.DataViewModel
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private val viewModel: DataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.viewToolbar.toolbar)

        binding.fabAddRecipe.setOnClickListener { view ->
            Snackbar.make(view, R.string.main_activity_snackbar_add_recipe, Snackbar.LENGTH_LONG)
                .setAction(R.string.main_activity_action_add_recipe, null)
                .setAnchorView(R.id.fab_add_recipe).show()
        }

        val repository = DataStoreRepositoryImpl(this)
        viewModel.saveFirstAccess(repository, false)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}