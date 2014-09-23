package org.jetbrains.teamcity.buildChainExport.controllers;

import javax.servlet.http.HttpServletRequest;
import jetbrains.buildServer.web.openapi.PagePlaces;
import jetbrains.buildServer.web.openapi.PlaceId;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import jetbrains.buildServer.web.openapi.SimplePageExtension;
import jetbrains.buildServer.web.util.WebUtil;
import org.jetbrains.annotations.NotNull;

public class BuildResultsExtension extends SimplePageExtension {
  public BuildResultsExtension(@NotNull PagePlaces pagePlaces, @NotNull PluginDescriptor pluginDescriptor) {
    super(pagePlaces);
    setIncludeUrl(pluginDescriptor.getPluginResourcesPath("buildResults.jsp"));
    setPlaceId(PlaceId.ALL_PAGES_FOOTER);
    setPluginName(pluginDescriptor.getPluginName());
    register();
  }

  @Override
  public boolean isAvailable(@NotNull final HttpServletRequest request) {
    return super.isAvailable(request) && WebUtil.getPathWithoutContext(request).startsWith("/viewLog.html");
  }
}
