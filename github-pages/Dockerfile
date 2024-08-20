FROM --platform=linux/arm64/v8 jekyll/jekyll:latest

WORKDIR /srv/jekyll
RUN echo 'source "https://rubygems.org"' >> Gemfile && \
# Ruby 3.0以降包含されておらず、jekyll/jekyll:4のRuby versionが、本Docker環境構築時点で3.1.1のため
echo 'gem "webrick"' >> Gemfile && \
# RUN echo 'gem "jekyll", "3.10.0" ' >> Gemfile
echo 'gem "jekyll-theme-minimal"' >> Gemfile && \
echo 'gem "github-pages",  "232", group: :jekyll_plugins' >> Gemfile && \
bundle install