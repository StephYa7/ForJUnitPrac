package Prac_4.http;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WebServiceTest {

    String reply = "\n" +
            "<!doctype html>\n" +
            "<html dir=\"ltr\" lang=\"en\"\n" +
            "    chrome-refresh-2023>\n" +
            "  <head>\n" +
            "    <meta charset=\"utf-8\">\n" +
            "    <title>New Tab</title>\n" +
            "    <style>\n" +
            "      body {\n" +
            "        background: #FDFAEC;\n" +
            "        margin: 0;\n" +
            "      }\n" +
            "\n" +
            "      #backgroundImage {\n" +
            "        border: none;\n" +
            "        height: 100%;\n" +
            "        pointer-events: none;\n" +
            "        position: fixed;\n" +
            "        top: 0;\n" +
            "        visibility: hidden;\n" +
            "        width: 100%;\n" +
            "      }\n" +
            "\n" +
            "      [show-background-image] #backgroundImage {\n" +
            "        visibility: visible;\n" +
            "      }\n" +
            "    </style>\n" +
            "  </head>\n" +
            "  <body>\n" +
            "    <iframe id=\"backgroundImage\" src=\"chrome-untrusted://new-tab-page/custom_background_image?url=https%3A%2F%2Flh3.googleusercontent.com%2Fproxy%2FnMIspgHzTUU0GzmiadmPphBelzF2xy9-tIiejZg3VvJTITxUb-1vILxf-IsCfyl94VSn6YvHa8_PiIyR9d3rwD8ZhNdQ1C1rnblP6zy3OaI%3Dw3840-h2160-p-k-no-nd-mv\"></iframe>\n" +
            "    <ntp-app></ntp-app>\n" +
            "    <script type=\"module\" src=\"new_tab_page.js\"></script>\n" +
            "    <link rel=\"stylesheet\" href=\"chrome://resources/css/text_defaults_md.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"chrome://theme/colors.css?sets=ui,chrome\">\n" +
            "    <link rel=\"stylesheet\" href=\"shared_vars.css\">\n" +
            "  </body>\n" +
            "</html>\n";
    @Test
    void httpRequest() {
        HttpClient mockHttpClient = mock(HttpClient.class);
        when(mockHttpClient.get(anyString())).thenReturn(reply);
        WebService webService = new WebService(mockHttpClient);

        String result = webService.httpRequest("123");
        assertEquals(reply, result);
    }


}