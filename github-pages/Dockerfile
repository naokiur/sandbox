#FROM --platform=linux/arm64/v8 jekyll/jekyll:4
FROM --platform=linux/arm64/v8 jekyll/jekyll:3.8.5

WORKDIR /srv/jekyll
RUN echo 'source "https://rubygems.org"' >> Gemfile
# Ruby 3.0以降包含されておらず、jekyll/jekyllのRuby versionが、本Docker環境構築時点で3.1.1のため
RUN echo 'gem "webrick"' >> Gemfile
#RUN echo 'gem "github-pages",  "~> 232", group: :jekyll_plugins' >> Gemfile
RUN bundle install