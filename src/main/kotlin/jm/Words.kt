package jm

val excludes = setOf(
    "aa",
    "ab",
    "ac",
    "ad",
    "ae",
    "af",
    "ag",
    // "ah",
    "ai",
    "aj",
    "ak",
    "al",
    // "am",
    // "an",
    "ap",
    "ar",
    // "as",
    // "at",
    "au",
    "av",
    // "aw",
    "az",
    "ba",
    "bb",
    "bc",
    "bd",
    // "be",
    "bg",
    "bi",
    "bk",
    "bl",
    "bm",
    "bo",
    "bp",
    "br",
    "bs",
    "bt",
    "bw",
    "by",
    "ca",
    "cb",
    "cc",
    "cd",
    "ce",
    "cf",
    "cg",
    "ch",
    "ci",
    "cj",
    "cl",
    "cm",
    "cn",
    // "co",
    "cp",
    "cr",
    "cs",
    "ct",
    "cu",
    "cv",
    "cw",
    "cz",
    "da",
    "db",
    "dc",
    "dd",
    "de",
    "df",
    "dg",
    "dh",
    "di",
    "dj",
    "dk",
    "dl",
    "dm",
    // "do",
    "dp",
    "dr",
    "ds",
    "dt",
    "du",
    "dv",
    "dx",
    "ea",
    "ec",
    // "ed",
    "ee",
    "ef",
    "eg",
    // "eh",
    "el",
    "em",
    "en",
    "ep",
    "eq",
    // "er",
    "es",
    "et",
    "eu",
    "ev",
    "ex",
    "ez",
    "fa",
    "fc",
    "fd",
    "fe",
    "ff",
    "fg",
    "fi",
    "fl",
    "fm",
    "fo",
    "fp",
    "fr",
    "fs",
    "ft",
    "fu",
    "fw",
    "fx",
    "fy",
    "ga",
    "gb",
    "gc",
    "gd",
    "ge",
    "gg",
    "gi",
    "gl",
    "gm",
    // "go",
    "gp",
    "gr",
    "gs",
    "gt",
    // "ha",
    "hb",
    "hc",
    "hd",
    // "he",
    "hh",
    // "hi",
    "hk",
    "hl",
    // "ho",
    "hp",
    "hq",
    "hr",
    "hs",
    "ht",
    "hu",
    "hz",
    "ia",
    "ic",
    "id",
    "ie",
    "if",
    "ii",
    "il",
    "im",
    // "in",
    "io",
    "ip",
    "ir",
    // "is",
    // "it",
    "iv",
    "ix",
    "ja",
    "jc",
    "jd",
    "je",
    "jj",
    "jm",
    "jo",
    "jp",
    "jr",
    "js",
    "ka",
    "kb",
    "kg",
    "km",
    "ko",
    "ks",
    "kw",
    "ky",
    "la",
    "lb",
    "lc",
    "ld",
    "le",
    "lf",
    "lg",
    "li",
    "ll",
    "lm",
    "ln",
    // "lo",
    "lp",
    "ls",
    "lt",
    "lu",
    // "ma",
    "mb",
    "mc",
    "md",
    // "me",
    "mf",
    "mg",
    "mh",
    "mi",
    "mj",
    "ml",
    "mm",
    "mn",
    // "mo",
    "mp",
    // "mr",
    // "ms",
    // "mt",
    // "mu",
    "mv",
    "mw",
    "mx",
    "my",
    "na",
    "nb",
    "nc",
    "nd",
    "ne",
    "ng",
    "nh",
    "ni",
    "nj",
    "nl",
    "nm",
    "nn",
    // "no",
    "np",
    "nr",
    "ns",
    "nt",
    "nu",
    "nv",
    "nw",
    "ny",
    "nz",
    "ob",
    "oc",
    "oe",
    // "of",
    "og",
    // "oh",
    // "ok",
    "ol",
    "om",
    // "on",
    "oo",
    "op",
    "or",
    "os",
    "ot",
    "ou",
    "oz",
    "pa",
    "pb",
    "pc",
    "pd",
    "pe",
    "pf",
    "pg",
    "ph",
    // "pi",
    "pj",
    "pk",
    "pl",
    "pm",
    "pn",
    "po",
    "pp",
    "pr",
    "ps",
    "pt",
    "qc",
    "qt",
    "ra",
    "rb",
    "rc",
    "rd",
    "re",
    "rf",
    "rg",
    "rh",
    "ri",
    "rj",
    "rl",
    "rm",
    "rn",
    "ro",
    "rp",
    "rr",
    "rs",
    "rt",
    "ru",
    "rv",
    "rw",
    "rx",
    "sa",
    "sb",
    "sc",
    "sd",
    "se",
    "sf",
    "sg",
    "sh",
    "si",
    "sk",
    "sl",
    "sm",
    "sn",
    // "so",
    "sp",
    "sq",
    "sr",
    "ss",
    "st",
    "su",
    "sv",
    "sw",
    "ta",
    "tb",
    "tc",
    "td",
    "te",
    "tf",
    "th",
    "ti",
    "tm",
    "tn",
    // "to",
    "tp",
    "tr",
    "ts",
    "tt",
    "tu",
    "tv",
    "tx",
    "ty",
    "uc",
    "uh",
    "ui",
    "uk",
    "ul",
    "um",
    "un",
    "up",
    // "ur",
    // "us",
    "ut",
    "uv",
    "uw",
    "va",
    "vb",
    "vc",
    "ve",
    "vg",
    "vi",
    "vp",
    "vs",
    "vt",
    "wa",
    "wb",
    "wc",
    // "we",
    "wi",
    "wm",
    "wn",
    "wp",
    "wr",
    "ws",
    "wt",
    "wu",
    "wv",
    "ww",
    "wx",
    "wy",
    "xi",
    "xl",
    "xp",
    "xx",
    "ya",
    "ye",
    "yn",
    //"yo",
    "yr",
    "yu",
    "za",
    "zu",
)

val othersToRemove = setOf("nat", "titten", "cunt", "mas", "mai", "tri", "med", "ima", "ata", "pda", "tee", "tit", "und",
    "dem", "dat", "mae", "ma", "tee", "ed", "ted", "kai", "ken", "rep", "mar", "dan", "tim", "mr", "ent", "alt", "rna",
    "tex", "pts", "kim", "cet", "kde", "ana", "yea", "msn", "mia", "ing", "eng", "ste", "aaa", "ati")

val toAdd = setOf("alan", "turing", "bletchley", "park", "com", "org", "co", "uk")

class Words {
    companion object WORDS {
        val wordList = javaClass.getResource("/words.txt")?.let { it.readText().split('\n').toSet() - excludes - othersToRemove + toAdd} ?: throw Error("couldn't find word list")
    }
}