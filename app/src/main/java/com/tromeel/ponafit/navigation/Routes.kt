package com.tromeel.ponafit.navigation


const val ROUT_HOME = "home"
const val ROUT_ABOUT = "about"
const val ROUT_SPLASH = "splash"
const val ROUT_DASHBOARD = "dashboard"
const val ROUT_ACCOUNT = "account"
const val ROUT_HISTORY = "history"







//auth
const val ROUT_REGISTER = "register"
const val ROUT_LOGIN = "login"

//Homexercise
const val ROUT_HOMEEXERCISES = "homeexercises"
const val ROUT_BFULLBODYWORKOUT = "bfullbodyworkout"
const val ROUT_BUPPERBODY = "bupperbody"
const val ROUT_BLOWERBODY = "blowerbody"
const val ROUT_BCORE = "bcore"
const val ROUT_IFULLBODYWORKOUT = "ifullbodyworkout"
const val ROUT_IUPPERBODY = "iupperbody"
const val ROUT_ILOWERBODY = "ilowerbody"
const val ROUT_ICORE = "icore"
const val ROUT_AFULLBODYWORKOUT = "afullbodyworkout"
const val ROUT_AUPPERBODY = "aupperbody"
const val ROUT_ALOWERBODY = "alowerbody"
const val ROUT_ACORE = "acore"
const val ROUT_FDIFFICULTY = "fdifficulty"
const val ROUT_UDIFFICULTY = "udifficulty"
const val ROUT_LDIFFICULTY = "ldifficulty"
const val ROUT_CDIFFICULTY = "cdifficulty"


//Gymexercise
const val ROUT_GYMEXERCISES = "gymexercises"
const val ROUT_GFDIFFICULTY = "gfdifficulty"
const val ROUT_GUDIFFICULTY = "gudifficulty"
const val ROUT_GLDIFFICULTY = "gldifficulty"
const val ROUT_GCDIFFICULTY = "gcdifficulty"
const val ROUT_GBFULLBODY = "gbfullbody"
const val ROUT_GBUPPERBODY = "gbupperbody"
const val ROUT_GBLOWERBODY = "gblowerbody"
const val ROUT_GBCORE = "gbcore"
const val ROUT_GIFULLBODY = "gifullbody"
const val ROUT_GIUPPERBODY = "giupperbody"
const val ROUT_GILOWERBODY = "gilowerbody"
const val ROUT_GICORE = "gicore"
const val ROUT_GACORE = "gacore"
const val ROUT_GAFULLBODY = "gafullbody"
const val ROUT_GAUPPERBODY = "gaupperbody"

const val ROUT_GALOWERBODY = "galowerbody"

//Strethingexercise
const val ROUT_STRETCHINGEXERCISES = "stretchingexercises"
const val ROUT_FULLBODYSTRETCHING = "fullbodystretching"
const val ROUT_UPPERBODYSTRETCHING = "upperbodystretching"
const val ROUT_LOWERBODYSTRETCHING = "lowerbodystretching"
const val ROUT_DYNAMICWARMUPS = "dynamicwarmups"
const val ROUT_COOLDOWN = "cooldown"


//REHAB
const val ROUT_REHAB = "rehab"
const val ROUT_KNEE = "knee"
const val ROUT_SHOULDER = "shoulder"
const val ROUT_LOWERBACK = "lowerback"
const val ROUT_ANKLEFOOT = "anklefoot"
const val ROUT_HIP = "hip"
const val ROUT_WRISTELBOW = "wristelbow"
const val ROUT_NECK = "neck"


//PHYSIO
const val ROUT_ADD_PHYSIO = "add_product"
const val ROUT_PHYSIO_LIST = "physio_list"
const val ROUT_EDIT_PHYSIO = "edit_physio/{physioId}"
fun editPhysioRoute(physioId: Int) = "edit_physio/$physioId"

