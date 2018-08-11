/*
 * Copyright (c) 2016-17 Memorial Sloan-Kettering Cancer Center.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY, WITHOUT EVEN THE IMPLIED WARRANTY OF MERCHANTABILITY OR FITNESS
 * FOR A PARTICULAR PURPOSE. The software and documentation provided hereunder
 * is on an "as is" basis, and Memorial Sloan-Kettering Cancer Center has no
 * obligations to provide maintenance, support, updates, enhancements or
 * modifications. In no event shall Memorial Sloan-Kettering Cancer Center be
 * liable to any party for direct, indirect, special, incidental or
 * consequential damages, including lost profits, arising out of the use of this
 * software and its documentation, even if Memorial Sloan-Kettering Cancer
 * Center has been advised of the possibility of such damage.
 */

/*
 * This file is part of cBioPortal.
 *
 * cBioPortal is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package org.cbio.portal.pipelines.foundation.model.staging;

import org.cbio.portal.pipelines.foundation.model.CaseType;
import org.cbio.portal.pipelines.foundation.model.MetricType;
import org.cbio.portal.pipelines.foundation.model.NonHumanType;
import org.cbio.portal.pipelines.foundation.util.FoundationUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Class for converting CaseType to ClinicalData
 * @author Prithi Chakrapani, ochoaa
 */
public class PatientData {

    private String patientId;
    private String gender;
    private Map<String, String> additionalProperties;

    public PatientData(){}

    public PatientData(CaseType caseType) {
        this.patientId = caseType.getCase().replace(":", "-");
        this.gender = caseType.getVariantReport().getGender();
    }
    
    /** 
     * @return the sampleId
     */
    public String getPatientId() {
        return patientId;
    }

    /**
     * @param patientId the patientId to set
     */
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }


    /**
     * Returns a map linking the staging file column name to the appropriate getter method.
     * @return 
     */
    public Map<String, String> getStagingMap(){
        Map<String, String> map = new LinkedHashMap<>();
        map.put("PATIENT_ID","getPatientId");
        map.put("SEX","getGender");

        return map;
    }        

}
