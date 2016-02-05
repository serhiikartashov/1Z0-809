Internationalization is also abbreviated as i18n because there are 18 
letters between i and n. Localization is also abbreviated as l10n 
because there are 10 letters between 1 and n.

#Internationalization 
is the process of designing an application in a manner that it 
can be adapted to various locales.

#Localization 
is the process of adapting your software for a locale by adding 
locale-specific components and translating text.

Language's list
http://www.loc.gov/standards/iso639-2/php/English_list.php

Country's list
http://userpage.chemie.fu-berlin.de/diverse/doc/ISO_3166.html

Variant is a vendor or browser specific code, 
such as WIN for Windows, MAC for Macintosh
Two or more variant values each indicating its own semantics, 
these values should be ordered by importance, with most important first, 
separated by underscore('_'). The variant field is case sensitive.

ja_JP_JP_#u-ca-japanese
ja - language
JP - country
JP - variant
u - extension key
ca - unicode locale key
japanese - locale type

th_TH_TH_#u-nu-thai
th - language
TH - country
TH - variant
u - extension key
nu - unicode locale key
thai - locale type

Locales:
http://www.localeplanet.com/java/
http://www.localeplanet.com/java/hi-IN/

                      ResourceBundle (abstract)
                            |
         |                                   |
ListResourceBundle (abstract)      PropertyResourceBundle

java -cp ./target/classes certification.chapter5.localization.resourcebundle.LocalizedHello
java -cp ./target/classes -Duser.language=it -Duser.region=IT certification.chapter5.localization.resourcebundle.LocalizedHello
java -cp ./target/classes -Duser.language=ar certification.chapter5.localization.resourcebundle.LocalizedHello


#Naming Convention for Resource Bundles

packagequalifier.bundlename + "_" + language + "_" + country + "_" + (variant + "_#" | "#") + script + "-" + extensions

i.e. localization.examples.AppBundle_en_US_Oracle_exam

In this case, 
localization.examples is the package, 
AppBundle is the name of the resource bundle, 
en is language (which stands for English), 
US is the country, 
and Oracle_exam is the variant.

#variant: 
An arbitrary list of variants (in lowercase or uppercase) to differentiate locales 
when you need more than one locale for a language and country combination.
i.e. ResourceBundle_it_IT_Rome.properties  -- Italian (Italy, Rome, Vatican) bundle


¤ is the Unicode Character 'CURRENCY SIGN'
http://www.fileformat.info/info/unicode/char/a4/index.htm

CLDR
http://openjdk.java.net/jeps/252
CLDR features
http://cldr.unicode.org/cldr-features#TOC-Locale-specific-patterns-for-formatting-and-parsing:


Internationalization Enhancements in JDK 8
https://docs.oracle.com/javase/8/docs/technotes/guides/intl/enhancements.8.html#api