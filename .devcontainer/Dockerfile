FROM mcr.microsoft.com/devcontainers/java:3-25-trixie

RUN apt-get update && \
    apt-get install -y openbox

RUN echo 'openbox-session &' >> ~/.xinitrc