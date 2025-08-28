package com.tromeel.ponafit.navigation


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tromeel.ponafit.data.UserDatabase
import com.tromeel.ponafit.repository.RepositoryProvider
import com.tromeel.ponafit.repository.UserRepository
import com.tromeel.ponafit.ui.screens.about.AboutScreen
import com.tromeel.ponafit.ui.screens.account.AccountScreen
import com.tromeel.ponafit.ui.screens.auth.LoginScreen
import com.tromeel.ponafit.ui.screens.auth.RegisterScreen
import com.tromeel.ponafit.ui.screens.dashboard.DashboardScreen
import com.tromeel.ponafit.ui.screens.gymexercises.GACoreScreen
import com.tromeel.ponafit.ui.screens.gymexercises.GAFullBodyScreen
import com.tromeel.ponafit.ui.screens.gymexercises.GALowerBodyScreen
import com.tromeel.ponafit.ui.screens.gymexercises.GAUpperBodyScreen
import com.tromeel.ponafit.ui.screens.gymexercises.GBCoreScreen
import com.tromeel.ponafit.ui.screens.gymexercises.GBFullBodyScreen
import com.tromeel.ponafit.ui.screens.gymexercises.GBLowerBodyScreen
import com.tromeel.ponafit.ui.screens.gymexercises.GBUpperBodyScreen
import com.tromeel.ponafit.ui.screens.gymexercises.GCDifficultyScreen
import com.tromeel.ponafit.ui.screens.gymexercises.GFDifficultyScreen
import com.tromeel.ponafit.ui.screens.gymexercises.GICoreScreen
import com.tromeel.ponafit.ui.screens.gymexercises.GIFullBodyScreen
import com.tromeel.ponafit.ui.screens.gymexercises.GILowerBodyScreen
import com.tromeel.ponafit.ui.screens.gymexercises.GIUpperBodyScreen
import com.tromeel.ponafit.ui.screens.gymexercises.GLDifficultyScreen
import com.tromeel.ponafit.ui.screens.gymexercises.GUDifficultyScreen
import com.tromeel.ponafit.ui.screens.gymexercises.GymExercisesScreen
import com.tromeel.ponafit.ui.screens.history.HistoryScreen
import com.tromeel.ponafit.ui.screens.home.HomeScreen
import com.tromeel.ponafit.ui.screens.homeexercises.ACoreScreen
import com.tromeel.ponafit.ui.screens.homeexercises.AFullBodyWorkoutScreen
import com.tromeel.ponafit.ui.screens.homeexercises.ALowerBodyScreen
import com.tromeel.ponafit.ui.screens.homeexercises.AUpperBodyScreen
import com.tromeel.ponafit.ui.screens.homeexercises.BCoreScreen
import com.tromeel.ponafit.ui.screens.homeexercises.BFullBodyWorkoutScreen
import com.tromeel.ponafit.ui.screens.homeexercises.BLowerBodyScreen
import com.tromeel.ponafit.ui.screens.homeexercises.BUpperBodyScreen
import com.tromeel.ponafit.ui.screens.homeexercises.CDifficultyScreen
import com.tromeel.ponafit.ui.screens.homeexercises.FDifficultyScreen
import com.tromeel.ponafit.ui.screens.homeexercises.HomeExercisesScreen
import com.tromeel.ponafit.ui.screens.homeexercises.ICoreScreen
import com.tromeel.ponafit.ui.screens.homeexercises.IFullBodyWorkoutScreen
import com.tromeel.ponafit.ui.screens.homeexercises.ILowerBodyScreen
import com.tromeel.ponafit.ui.screens.homeexercises.IUpperBodyScreen
import com.tromeel.ponafit.ui.screens.homeexercises.LDifficultyScreen
import com.tromeel.ponafit.ui.screens.homeexercises.UDifficultyScreen
import com.tromeel.ponafit.ui.screens.physio.AddPhysioScreen
import com.tromeel.ponafit.ui.screens.physio.EditPhysioScreen
import com.tromeel.ponafit.ui.screens.physio.PhysioListScreen
import com.tromeel.ponafit.ui.screens.rehab.AnkleFootRehabScreen
import com.tromeel.ponafit.ui.screens.rehab.HipRehabScreen
import com.tromeel.ponafit.ui.screens.rehab.KneeRehabScreen
import com.tromeel.ponafit.ui.screens.rehab.LowerBackRehabScreen
import com.tromeel.ponafit.ui.screens.rehab.NeckRehabScreen
import com.tromeel.ponafit.ui.screens.rehab.RehabScreen
import com.tromeel.ponafit.ui.screens.rehab.ShoulderRehabScreen
import com.tromeel.ponafit.ui.screens.rehab.WristElbowRehabScreen
import com.tromeel.ponafit.ui.screens.splash.SplashScreen
import com.tromeel.ponafit.ui.screens.stretchingexercises.CoolDownScreen
import com.tromeel.ponafit.ui.screens.stretchingexercises.DynamicWarmUpsScreen
import com.tromeel.ponafit.ui.screens.stretchingexercises.FullBodyStretchingScreen
import com.tromeel.ponafit.ui.screens.stretchingexercises.LowerBodyStretchingScreen
import com.tromeel.ponafit.ui.screens.stretchingexercises.StretchingExercisesScreen
import com.tromeel.ponafit.ui.screens.stretchingexercises.UpperBodyStretchingScreen
import com.tromeel.ponafit.viewmodel.AuthViewModel
import com.tromeel.ponafit.viewmodel.ExerciseViewModel
import com.tromeel.ponafit.viewmodel.PhysioViewModel



@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_GYMEXERCISES,
    physioViewModel: PhysioViewModel = viewModel(),

    ) {
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_HOME) {
            HomeScreen(navController)
        }
        composable(ROUT_ABOUT) {
            AboutScreen(navController)
        }

        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }

        composable(ROUT_DASHBOARD) {
            DashboardScreen(navController)
        }

        composable(ROUT_HOMEEXERCISES) {
            HomeExercisesScreen(navController)
        }
        composable(ROUT_ACCOUNT) {
            AccountScreen(navController)
        }
        composable(ROUT_HISTORY) {
            val context = LocalContext.current
            val repo = remember { RepositoryProvider.getRepository(context) }
            val vm = remember { ExerciseViewModel(repo) }
            HistoryScreen(navController, vm)
        }

        //Physio
        composable(ROUT_ADD_PHYSIO) {
            AddPhysioScreen(navController, physioViewModel)
        }

        composable(ROUT_PHYSIO_LIST) {
            PhysioListScreen(navController, physioViewModel)
        }

        composable(
            route = ROUT_EDIT_PHYSIO,
            arguments = listOf(navArgument("physioId") { type = NavType.IntType })
        ) { backStackEntry ->
            val physioId = backStackEntry.arguments?.getInt("physioId")
            if (physioId != null) {
                EditPhysioScreen(physioId, navController, physioViewModel)
            }
        }




















        ///BEGINNER WORKOUTS

        composable(ROUT_BFULLBODYWORKOUT) {
            BFullBodyWorkoutScreen(navController)
        }

        composable(ROUT_GBFULLBODY) {
            GBFullBodyScreen(navController)
        }

        composable(ROUT_GBUPPERBODY) {
            GBUpperBodyScreen(navController)
        }

        composable(ROUT_GBLOWERBODY) {
            GBLowerBodyScreen(navController)
        }

        composable(ROUT_BUPPERBODY) {
            BUpperBodyScreen(navController)
        }
        composable(ROUT_BLOWERBODY) {
            BLowerBodyScreen(navController)
        }

        composable(ROUT_BCORE) {
            BCoreScreen(navController)
        }

        composable(ROUT_GBCORE) {
            GBCoreScreen(navController)
        }





        //INTERMEDIATE WORKOUTS


        composable(ROUT_IFULLBODYWORKOUT) {
            IFullBodyWorkoutScreen(navController)
        }

        composable(ROUT_IUPPERBODY) {
            IUpperBodyScreen(navController)
        }
        composable(ROUT_ILOWERBODY) {
            ILowerBodyScreen(navController)
        }
        composable(ROUT_ICORE) {
            ICoreScreen(navController)
        }

        composable(ROUT_GIFULLBODY) {
            GIFullBodyScreen(navController)
        }

        composable(ROUT_GIUPPERBODY) {
            GIUpperBodyScreen(navController)
        }


        composable(ROUT_GILOWERBODY) {
            GILowerBodyScreen(navController)
        }

        composable(ROUT_GICORE) {
            GICoreScreen(navController)
        }







        //ADVANCED WORKOUTS
        composable(ROUT_AFULLBODYWORKOUT) {
            AFullBodyWorkoutScreen(navController)
        }

        composable(ROUT_AUPPERBODY) {
            AUpperBodyScreen(navController)
        }


        composable(ROUT_ALOWERBODY) {
            ALowerBodyScreen(navController)
        }

        composable(ROUT_ACORE) {
            ACoreScreen(navController)
        }


        composable(ROUT_GAFULLBODY) {
            GAFullBodyScreen(navController)
        }

        composable(ROUT_GAUPPERBODY) {
            GAUpperBodyScreen(navController)
        }

        composable(ROUT_GALOWERBODY) {
            GALowerBodyScreen(navController)
        }
        composable(ROUT_GACORE) {
            GACoreScreen(navController)
        }











        //DIFFICULTY SCREENS
        composable(ROUT_FDIFFICULTY) {
            FDifficultyScreen(navController)
        }
        composable(ROUT_GFDIFFICULTY) {
            GFDifficultyScreen(navController)
        }

        composable(ROUT_GUDIFFICULTY) {
            GUDifficultyScreen(navController)
        }
        composable(ROUT_GLDIFFICULTY) {
            GLDifficultyScreen(navController)
        }

        composable(ROUT_GCDIFFICULTY) {
            GCDifficultyScreen(navController)
        }

        composable(ROUT_UDIFFICULTY) {
            UDifficultyScreen(navController)
        }

        composable(ROUT_LDIFFICULTY) {
            LDifficultyScreen(navController)
        }

        composable(ROUT_CDIFFICULTY) {
            CDifficultyScreen(navController)
        }




        //STRETCHING EXERCISE
        composable(ROUT_STRETCHINGEXERCISES) {
            StretchingExercisesScreen(navController)
        }

        composable(ROUT_FULLBODYSTRETCHING) {
            FullBodyStretchingScreen(navController)
        }

        composable(ROUT_UPPERBODYSTRETCHING) {
            UpperBodyStretchingScreen(navController)
        }

        composable(ROUT_LOWERBODYSTRETCHING) {
            LowerBodyStretchingScreen(navController)
        }

        composable(ROUT_DYNAMICWARMUPS) {
            DynamicWarmUpsScreen(navController)
        }

        composable(ROUT_COOLDOWN) {
            CoolDownScreen(navController)
        }



        //REHAB


        composable(ROUT_REHAB) {
            RehabScreen(navController)
        }


        composable(ROUT_KNEE) {
            KneeRehabScreen(navController)
        }
         composable(ROUT_SHOULDER) {
            ShoulderRehabScreen(navController)
        }
        composable(ROUT_LOWERBACK) {
            LowerBackRehabScreen(navController)
        }
        composable(ROUT_ANKLEFOOT) {
            AnkleFootRehabScreen(navController)
        }
        composable(ROUT_HIP) {
            HipRehabScreen(navController)
        }
        composable(ROUT_WRISTELBOW) {
            WristElbowRehabScreen(navController)
        }

        composable(ROUT_NECK) {
            NeckRehabScreen(navController)
        }














        composable(ROUT_GYMEXERCISES) {
            GymExercisesScreen(navController)
        }




        //AUTHENTICATION

        // Initialize Room Database and Repository for Authentication
        val appDatabase = UserDatabase.getDatabase(context)
        val authRepository = UserRepository(appDatabase.userDao())
        val authViewModel: AuthViewModel = AuthViewModel(authRepository)
        composable(ROUT_REGISTER) {
            RegisterScreen(authViewModel, navController) {
                navController.navigate(ROUT_LOGIN) {
                    popUpTo(ROUT_REGISTER) { inclusive = true }
                }
            }
        }

        composable(ROUT_LOGIN) {
            LoginScreen(authViewModel, navController) {
                navController.navigate(ROUT_HOME) {
                    popUpTo(ROUT_LOGIN) { inclusive = true }
                }
            }
        }


    }
}