---
title: Twitch Tokens
description: In this section we are going to see how to obtain twitch credentials or tokens to be able to use them with our plugin
layout: ../../../layouts/MainLayout.astro
lang: en-us
---

# Twitch Tokens

In this section we are going to see how to obtain twitch credentials or tokens to be able to use them with our plugin

---

## Prerequisites

- You will need at least one twitch account. _Note: If you want a message to appear in your twitch chat when someone activates a reward, you can choose to have another account other than yours speak in the chat, as if it were a chatbot._

-

## Steps

1. We have to make a twitch app, if you already have one you can skip to step 5
2. Login on https://dev.twitch.tv/ with your streamer account. _Note: It is necessary to enter with the account with which you are going to stream since only with that account you can see the subscriptions, necessary for the plugin._
3. Now it will go to the next page and it will create an application https://dev.twitch.tv/console/apps
4. In the "Name" section you can put what you want, and in the "OAuth Redirect URLs" section you will put `https://twitchtokengenerator.com`, finally in the category we will choose Chat Bot.
5. then when the application appears we will click on "Manage" we will copy the Client ID and create a Client Secret.
6. Now we are going to go to https://twitchtokengenerator.com/ and we are going to fill in the Client ID and Client Secret data
7. We will activate all the permissions or at least these permissions:
   - bits:read
   - chat:read
   - channel:read:subscriptions
   - channel:read:redemptions
   - channel:read:hype_train
8. We will give "Generate token!"
9. When we get our credentials we will fill the configuration as shown below.

## Section on config.yml

```yaml
twitch:
  token: "HERE ACCESS TOKEN"
  refresh:
    refresh_token: "HERE REFRESH TOKEN"
    client_id: "HERE CLIENT ID"
    client_secret: "HERE CLIENT SECRET"
  chat-token: "" # "" use token default
  channels:
    - luisbazan/111111111
```

10. In the channels section you have to put the channels with the following format `<channel username>/<channel id>` to get the channel id you can use this tool [www.streamweasels.com](https://www.streamweasels.com/tools/convert-twitch-username-to-user-id/)

## ⇀ [Setup config.yml](/TwitchKillMe/en-us/getting-started/started-configuration)
