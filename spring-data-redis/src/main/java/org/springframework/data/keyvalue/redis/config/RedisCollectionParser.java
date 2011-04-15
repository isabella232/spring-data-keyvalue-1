/*
 * Copyright 2011 the original author or authors.
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
package org.springframework.data.keyvalue.redis.config;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.springframework.data.keyvalue.redis.support.collections.RedisCollectionFactoryBean;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * Parser for the Redis <code>&lt;collection&gt;</code> element.
 * 
 * @author Costin Leau
 */
public class RedisCollectionParser extends AbstractSimpleBeanDefinitionParser {

	@Override
	protected Class<?> getBeanClass(Element element) {
		return RedisCollectionFactoryBean.class;
	}

	@Override
	protected void postProcess(BeanDefinitionBuilder beanDefinition, Element element) {
		String template = element.getAttribute("template");
		if (StringUtils.hasText(template)) {
			beanDefinition.addPropertyReference("template", template);
		}
	}

	@Override
	protected boolean isEligibleAttribute(String attributeName) {
		return super.isEligibleAttribute(attributeName) && (!"template".equals(attributeName));
	}
}