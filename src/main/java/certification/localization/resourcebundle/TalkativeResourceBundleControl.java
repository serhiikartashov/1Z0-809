package certification.localization.resourcebundle;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Serhii K. on 11/24/2015.
 */
public class TalkativeResourceBundleControl extends ResourceBundle.Control {

    public List<Locale> getCandidateLocales(String baseName, Locale locale) {
        List<Locale> candidateLocales = super.getCandidateLocales(baseName, locale);
        System.out.printf("Candidate locales for base bundle name %s and locale %s %n", baseName, locale.getDisplayName());
        for (Locale candidateLocale : candidateLocales) {
            System.out.println(candidateLocale);
        }
        return candidateLocales;
    }
}
