package certification.localization.resourcebundle;

import java.util.ListResourceBundle;

/**
 * Created by Serhii K. on 11/24/2015.
 */
public class ResBundle extends ListResourceBundle{
    @Override
    protected Object[][] getContents() {
        return contents;
    }

    static final Object[][] contents = {
            {"MovieName", "Avatar"},
            {"GrossRevenue", (Long)2782275172L},
            {"Year", (Integer)2009}
    };
}
