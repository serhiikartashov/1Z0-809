package certification.localization.resourcebundle;

import java.util.ListResourceBundle;

/**
 * Created by Serhii K. on 11/24/2015.
 */
public class ResBundle_it_IT extends ListResourceBundle{

    @Override
    protected Object[][] getContents() {
        return contents;
    }

    static final Object[][] contents = {
            {"MovieName", "Che Bella Giornata"},
            {"GrossRevenue", (Long)43000000L},
            {"Year", (Integer)2011}
    };
}
