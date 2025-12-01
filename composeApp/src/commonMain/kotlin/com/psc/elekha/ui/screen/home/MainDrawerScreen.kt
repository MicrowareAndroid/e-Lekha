package com.wise.astitva.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.wise.astitva.database.viewmodel.BlockViewModel
import com.wise.astitva.database.viewmodel.CaseCategoryQuestionViewmodel
import com.wise.astitva.database.viewmodel.CaseFlagViewmodel
import com.wise.astitva.database.viewmodel.CriminalCaseTrackingViewmodel
import com.wise.astitva.database.viewmodel.CrossCuttingViewmodel
import com.wise.astitva.database.viewmodel.DistrictViewModel
import com.wise.astitva.database.viewmodel.LookUpValueViewmodel
import com.wise.astitva.database.viewmodel.LookupViewmodel
import com.wise.astitva.database.viewmodel.TblLanguageMasterViewmodel
import com.wise.astitva.database.viewmodel.StateViewModel
import com.wise.astitva.database.viewmodel.SubCategoryViewmodel
import com.wise.astitva.database.viewmodel.TblProfileComplainantViewmodel
import com.wise.astitva.database.viewmodel.TrackSubCategoryViewmodel
import com.wise.astitva.database.viewmodel.JankarViewmodel
import com.wise.astitva.expectfile.Localization
import com.wise.astitva.model.LanguageDataModel
import com.wise.astitva.ui.theme.black
import com.wise.astitva.ui.theme.lightGrey
import com.wise.astitva.ui.theme.teal700
import com.wise.astitva.ui.theme.white
import com.wise.astitva.utils.AppPreferences
import com.wise.astitva.utils.CommonActionButtons
import com.wise.astitva.utils.DrawerItem
import com.wise.astitva.utils.ReusableTextView
import com.wise.astitva.utils.ReusableTopBar
import com.wise.astitva.utils.RouteName
import dev.burnoo.compose.remembersetting.rememberStringSetting
import astitva.composeapp.generated.resources.Res
import astitva.composeapp.generated.resources.app_name
import astitva.composeapp.generated.resources.are_you_sure_logout
import astitva.composeapp.generated.resources.cancel
import astitva.composeapp.generated.resources.change_lang
import astitva.composeapp.generated.resources.ic_bug
import astitva.composeapp.generated.resources.ic_home
import astitva.composeapp.generated.resources.ic_language
import astitva.composeapp.generated.resources.ic_logout
import astitva.composeapp.generated.resources.ic_menu
import astitva.composeapp.generated.resources.inter_medium
import astitva.composeapp.generated.resources.poppins_medium
import astitva.composeapp.generated.resources.save
import astitva.composeapp.generated.resources.select_pref_lang
import com.wise.astitva.database.entity.MstLanguageEntity
import com.wise.astitva.database.viewmodel.TblCaseCategoryViewModel
import com.wise.astitva.ui.theme.cancelBgColor
import com.wise.astitva.ui.theme.yellowish
import com.wise.astitva.utils.AppSP
import com.wise.astitva.utils.CommonSingleButtons
import com.wise.astitva.utils.returnIntegerValue
import com.wise.astitva.utils.returnStringValue
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainDrawerScreen(navController: NavHostController, appPreferences: AppPreferences) {

    val localization = koinInject<Localization>()
    var languageIso by rememberStringSetting(
        key = "savedLanguageIso",
        defaultValue = LanguageDataModel.English.iso
    )

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedScreen by remember { mutableStateOf("Home") }
    var showLanguageDialog by remember { mutableStateOf(false) }
    var showLogoutDialog by remember { mutableStateOf(false) }

    /*Database*/
    val blockViewModel = koinViewModel<BlockViewModel>()
    val caseCategoryQuestionViewmodel = koinViewModel<CaseCategoryQuestionViewmodel>()
    val caseFlagViewmodel = koinViewModel<CaseFlagViewmodel>()
    val categoryViewmodel = koinViewModel<TblCaseCategoryViewModel>()
    val criminalCaseTrackingViewmodel = koinViewModel<CriminalCaseTrackingViewmodel>()
    val crossCuttingViewmodel = koinViewModel<CrossCuttingViewmodel>()
    val districtViewModel = koinViewModel<DistrictViewModel>()
    val lookUpValueViewmodel = koinViewModel<LookUpValueViewmodel>()
    val lookupViewmodel = koinViewModel<LookupViewmodel>()
    val mstLanguageViewmodel = koinViewModel<TblLanguageMasterViewmodel>()
    val stateViewModel = koinViewModel<StateViewModel>()
    val subCategoryViewmodel = koinViewModel<SubCategoryViewmodel>()
    val tblProfileComplainantViewmodel = koinViewModel<TblProfileComplainantViewmodel>()
    val trackSubCategoryViewmodel = koinViewModel<TrackSubCategoryViewmodel>()
    val userViewmodel = koinViewModel<JankarViewmodel>()

    val languageList by mstLanguageViewmodel.languageList.collectAsState()

    LaunchedEffect(Unit) {
        mstLanguageViewmodel.getMstLangauge()
    }

    fun onItemClick(screen: String) {
        selectedScreen = screen
        scope.launch { drawerState.close() }
        if (screen == "Language") {
            showLanguageDialog = true
        }

        if (screen == "Logout") {
            showLogoutDialog = true
        }
    }

    fun deleteAllData() {
        /*all database delete*/
        blockViewModel.deleteAllBlock()
        caseCategoryQuestionViewmodel.deleteAllCaseCategoryQuestion()
        caseFlagViewmodel.deleteAllCaseFlag()
        categoryViewmodel.deleteAll()
        criminalCaseTrackingViewmodel.deleteAllCriminalCaseTrack()
        crossCuttingViewmodel.deleteAllCrossCuttingFlag()
        districtViewModel.deleteAllMstDistrict()
        lookUpValueViewmodel.deleteAllLookupValues()
        lookupViewmodel.deleteAllmstLanguage()
        mstLanguageViewmodel.deleteAllmstLanguage()
        stateViewModel.deleteAllMstState()
        subCategoryViewmodel.deleteAllsubCategories()
        tblProfileComplainantViewmodel.deleteAlltblProfileOfComplainant()
        trackSubCategoryViewmodel.deleteAllTrackSubcategory()
        userViewmodel.deleteAllsubCategories()
        /*delete preferences*/
        appPreferences.clearsharedprefrence()
        /* navigate to login and clear backstack */
        navController.navigate(RouteName.login) {
            popUpTo(0) { inclusive = true }
            launchSingleTop = true
        }

    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {

                Spacer(Modifier.height(24.dp))

                Text(
                    stringResource(Res.string.app_name),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(16.dp)
                )

                DrawerItem(
                    "Home",
                    selectedScreen == "Home",
                    { onItemClick("Home") },
                    painterResource(Res.drawable.ic_home)
                )

                DrawerItem(
                    "Language",
                    selectedScreen == "Language",
                    { onItemClick("Language") },
                    painterResource(Res.drawable.ic_language)
                )

                /*DrawerItem(
                    "Error Report",
                    selectedScreen == "Error Report",
                    { onItemClick("Error Report") },
                    painterResource(Res.drawable.ic_bug)
                )*/

                DrawerItem(
                    "Logout",
                    selectedScreen == "Logout",
                    { onItemClick("Logout") },
                    painterResource(Res.drawable.ic_logout)
                )

            }
        }
    ) {
        Scaffold(
            topBar = {
                ReusableTopBar(
                    title = selectedScreen,
                    navigationIcon = painterResource(Res.drawable.ic_menu),
                    fontFamily = FontFamily(Font(Res.font.inter_medium)),
                    onNavigationClick = {
                        scope.launch { drawerState.open() }
                    }
                )
            }
        ) { padding ->
            Box(
                Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                when (selectedScreen) {
                    "Home" -> HomeScreen(navController, appPreferences)
                    "Logout" -> HomeScreen(navController, appPreferences)
                    "Language" -> HomeScreen(navController, appPreferences)
                }

                if (showLanguageDialog) {
                    languagePopUpDialog(
                        languages = languageList,
                        onSave = { lang1 ->
                            languageIso = if (lang1 == 1) {
                                LanguageDataModel.English.iso
                            } else if (lang1 == 2) {
                                LanguageDataModel.Hindi.iso
                            } else {
                                LanguageDataModel.Marathi.iso
                            }
                            localization.applyLanguage(languageIso)
                            showLanguageDialog = false
                            appPreferences.putInt(AppSP.languageId, lang1)
                            navController.navigate(RouteName.home)
                        },
                        onClose = { showLanguageDialog = false }
                    )
                }

                if (showLogoutDialog) {
                    customAlertLogoutDialog(
                        showDialog = showLogoutDialog,
                        onCancel = {
                            showLogoutDialog = false
                        },
                        onOkClick = {
                            deleteAllData()
                            showLogoutDialog = false
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun languagePopUpDialog(
    title: String = stringResource(Res.string.change_lang),
    languages: List<MstLanguageEntity>,
    initialSelectedIndex: Int = 0,
    onSave: (Int) -> Unit = { _ -> },
    onClose: () -> Unit = {},
) {
    var selectedOption by remember { mutableStateOf(initialSelectedIndex) }

    Dialog(onDismissRequest = onClose) {

        Box(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .heightIn(max = 500.dp)
                .background(yellowish, RoundedCornerShape(16.dp))
        ) {
            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(top = 6.dp)
                    .fillMaxWidth()
                    .heightIn(max = 500.dp)
                    .background(lightGrey, RoundedCornerShape(16.dp))
                    .border(1.dp, lightGrey, RoundedCornerShape(16.dp))
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(16.dp)
                        .wrapContentHeight()
                        .fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp)
                    ) {
                        ReusableTextView(
                            text = stringResource(Res.string.select_pref_lang),
                            fontSize = 16,
                            fontWeight = FontWeight.Normal,
                            textColor = black,
                            textAlignment = TextAlign.Center,
                            fontFamily = FontFamily(Font(Res.font.inter_medium))
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp)
                    ) {
                        ReusableTextView(
                            text = title,
                            fontSize = 20,
                            fontWeight = FontWeight.Bold,
                            textColor = black,
                            textAlignment = TextAlign.Center
                        )
                    }

                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.verticalScroll(rememberScrollState())
                    ) {
                        languages.forEachIndexed { index, language ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                RadioButton(
                                    selected = selectedOption == index,
                                    onClick = { selectedOption = index }
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                ReusableTextView(
                                    text = returnStringValue(language.lang),
                                    fontSize = 16
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    CommonSingleButtons(
                        text = stringResource(Res.string.save),
                        backgroundColor = yellowish,
                        onOkClick = {
                            onSave(returnIntegerValue(languages[selectedOption].lang_Id.toString()))
                            onClose()
                        }
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    CommonSingleButtons(
                        text = stringResource(Res.string.cancel),
                        backgroundColor = cancelBgColor,
                        onOkClick = {
                            onClose()
                        }
                    )
                }
            }
        }
    }
}

/*@Composable
fun languagePopUpDialog(
    title: String = stringResource(Res.string.change_lang),
    onSave: (Int) -> Unit = { _ -> },
    onClose: () -> Unit = {}
) {
    var selectedOption by remember { mutableStateOf(0) }

    Dialog(onDismissRequest = onClose) {
        Box(
            modifier = Modifier
                .wrapContentHeight()
                .widthIn(min = 300.dp, max = 400.dp)
                .heightIn(max = 500.dp)
                .background(lightGrey, RoundedCornerShape(16.dp))
                .border(1.dp, lightGrey, RoundedCornerShape(16.dp))
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentHeight()
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp)
                ) {
                    ReusableTextView(
                        text = title,
                        fontSize = 20,
                        fontWeight = FontWeight.Medium,
                        textColor = black,
                        textAlignment = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedOption == 0,
                            onClick = { selectedOption = 0 }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        ReusableTextView(text = "English", fontSize = 16)
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedOption == 1,
                            onClick = { selectedOption = 1 }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        ReusableTextView(text = "Hindi", fontSize = 16)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                CommonActionButtons(
                    onSaveClick = {
                        onSave(selectedOption)
                        onClose()
                    },
                    onCloseClick = { onClose() }
                )
            }
        }
    }
}
*/

@Composable
fun customAlertLogoutDialog(
    showDialog: Boolean,
    title: String = stringResource(Res.string.app_name),
    message: String = stringResource(Res.string.are_you_sure_logout),
    confirmText: String = "Logout",
    onOkClick: () -> Unit = {},
    onCancel: () -> Unit = {},
) {
    if (showDialog) {
        Dialog(
            onDismissRequest = { onCancel() },
        ) {
            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .widthIn(min = 400.dp, max = 500.dp)
                    .heightIn(max = 500.dp)
                    .background(lightGrey, RoundedCornerShape(16.dp))
                    .border(1.dp, lightGrey, RoundedCornerShape(16.dp))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(lightGrey, shape = RoundedCornerShape(16.dp))
                        .border(1.dp, Color.LightGray, shape = RoundedCornerShape(16.dp)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth().background(
                            teal700,
                            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                        ).heightIn(50.dp)
                    ) {
                        ReusableTextView(
                            text = title,
                            fontSize = 20,
                            fontWeight = FontWeight.Bold,
                            textColor = white,
                            textAlignment = TextAlign.Center,
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }

                    Spacer(Modifier.height(30.dp))

                    ReusableTextView(
                        text = message,
                        fontSize = 18,
                        textColor = black,
                        textAlignment = TextAlign.Center,
                        fontFamily = FontFamily(Font(Res.font.poppins_medium)),
                        modifier = Modifier.padding(bottom = 10.dp)
                    )

                    Spacer(Modifier.height(20.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(10.dp)
                    ) {
                        CommonActionButtons(
                            saveText = confirmText,
                            onSaveClick = {
                                onOkClick()
                                onCancel()
                            },
                            onCloseClick = { onCancel() }
                        )
                    }

                    Spacer(Modifier.height(10.dp))
                }
            }
        }
    }
}
