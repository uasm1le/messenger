package org.messenger.hooker.database;

import com.google.api.services.sheets.v4.Sheets;
import org.junit.BeforeClass;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class GoogleSheetsIntegrationTest {
    private static Sheets sheetsService;
    private static String SPREADSHEET__ID = "фів";

    @BeforeClass
    public static void setup() throws GeneralSecurityException, IOException {
        sheetsService = SheetsServiceUtil.getSheetsService();
    }

}
