/*
 * Copyright (C) 2017 José Paumard
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.paumard.katas.leapyears;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

/**
 * Created by José
 */
public class LeapYearTest {

    @Test
    public void should_return_false_for_year_2017() {

        // Given
        int year = 2017;
        LeapYear leapYear = new LeapYear();
        boolean expectedResult = false;

        // When
        boolean isLeapYear = leapYear.isLeapYear(year);

        // Than
        Assertions.assertThat(isLeapYear).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_false_for_year_2001_as_a_typical_common_year() {

        // Given
        int year = 2001;
        LeapYear leapYear = new LeapYear();
        boolean expectedResult = false;

        // When
        boolean isLeapYear = leapYear.isLeapYear(year);

        // Than
        Assertions.assertThat(isLeapYear).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_true_for_year_1996_as_a_typical_leap_year() {

        // Given
        int year = 1996;
        LeapYear leapYear = new LeapYear();
        boolean expectedResult = true;

        // When
        boolean isLeapYear = leapYear.isLeapYear(year);

        // Than
        Assertions.assertThat(isLeapYear).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_true_for_year_1992_as_a_typical_leap_year() {

        // Given
        int year = 1992;
        LeapYear leapYear = new LeapYear();
        boolean expectedResult = true;

        // When
        boolean isLeapYear = leapYear.isLeapYear(year);

        // Than
        Assertions.assertThat(isLeapYear).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_false_for_year_1900_as_an_atypical_common_year() {

        // Given
        int year = 1900;
        LeapYear leapYear = new LeapYear();
        boolean expectedResult = false;

        // When
        boolean isLeapYear = leapYear.isLeapYear(year);

        // Than
        Assertions.assertThat(isLeapYear).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_false_for_year_1800_as_an_atypical_common_year() {

        // Given
        int year = 1800;
        LeapYear leapYear = new LeapYear();
        boolean expectedResult = false;

        // When
        boolean isLeapYear = leapYear.isLeapYear(year);

        // Than
        Assertions.assertThat(isLeapYear).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_true_for_year_2000_as_an_atypical_leap_year() {

        // Given
        int year = 2000;
        LeapYear leapYear = new LeapYear();
        boolean expectedResult = true;

        // When
        boolean isLeapYear = leapYear.isLeapYear(year);

        // Than
        Assertions.assertThat(isLeapYear).isEqualTo(expectedResult);
    }
}
