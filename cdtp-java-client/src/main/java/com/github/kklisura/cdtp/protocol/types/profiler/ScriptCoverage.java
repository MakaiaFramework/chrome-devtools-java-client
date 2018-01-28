package com.github.kklisura.cdtp.protocol.types.profiler;

/*-
 * #%L
 * cdpt-java-client
 * %%
 * Copyright (C) 2018 Kenan Klisura
 * %%
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
 * #L%
 */

import com.github.kklisura.cdtp.protocol.support.annotations.Experimental;
import java.util.List;

/** Coverage data for a JavaScript script. */
@Experimental
public class ScriptCoverage {

  private String scriptId;

  private String url;

  private List<FunctionCoverage> functions;

  /** JavaScript script id. */
  public String getScriptId() {
    return scriptId;
  }

  /** JavaScript script id. */
  public void setScriptId(String scriptId) {
    this.scriptId = scriptId;
  }

  /** JavaScript script name or url. */
  public String getUrl() {
    return url;
  }

  /** JavaScript script name or url. */
  public void setUrl(String url) {
    this.url = url;
  }

  /** Functions contained in the script that has coverage data. */
  public List<FunctionCoverage> getFunctions() {
    return functions;
  }

  /** Functions contained in the script that has coverage data. */
  public void setFunctions(List<FunctionCoverage> functions) {
    this.functions = functions;
  }
}
