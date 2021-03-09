/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ClinicalTrialControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void rootEndpointShouldReturnHello() throws Exception {

        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("Hello from ClinicalTrials API!"));
    }

    @Test
    public void testGetAllTrilas() throws Exception {

        this.mockMvc.perform(get("/clinicaltrial"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content()
                        .string("[{\"nctId\":\"NCT00002537\",\"officialTitle\":\"A PHASE I STUDY " +
                                "OF PROLONGED LOW-DOSE TOPOTECAN INFUSION COMBINED WITH CHEST " +
                                "IRRADIATION\",\"phase\":\"I\"," +
                                "\"primaryCompletionDate\":\"2018-01-01T00:00:00.000Z\"}," +
                                "{\"nctId\":\"NCT00002556\",\"officialTitle\":\"The Treatment of " +
                                "Multiple Myeloma Utilizing VBMCP Chemotherapy Alternating with " +
                                "High-Dose Cyclophosphamide and Alpha2b-Interferon Versus VBMCP: " +
                                "A Phase III Study for Previously Untreated Multiple Myeloma\"," +
                                "\"phase\":\"III\",\"primaryCompletionDate\":\"2018-01-01T00:00:00.000Z\"}]"));
    }

}