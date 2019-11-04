## pureport/openstack4j Fork
This is a fork of https://github.com/ContainX/openstack4j

This document discusses the various processes that may help keep this repo's history simple.

### Pulling in upstream changes from ContainX
When ContainX performs a release, they will likely push a new tag generated from master.

Our process to update against that tag should be to:
1. Retrieve their new release tag and push it to our repo
2. Sync our master with their master
3. Merge the new release tag into our `pureport/develop` branch.
  - Resolve conflicts between version numbers by always using the upstream 
  version and then pureport's own version, `3.1.1-pureport-1.1-SNAPSHOT`

On the CLI this process looks like:
```shell script
git clone https://github.com/pureport/openstack4j.git
cd openstack4j
git remote add upstream https://github.com/ContainX/openstack4j
git pull upstream
git push --tags origin # Push new tags to origin
git checkout -b master origin/master
git merge upstream/master # Merge latest upstream/master into master and push
git push
git checkout -b pureport/develop origin/pureport/develop
git merge <tag> # Resolve conflicts with version numbers
git push
```

### Create a Release
Releases from `pureport/develop` should only go into `pureport/master`.  Our `pureport/master`
branch should reflect the latest pureport release tag.  The Jenkins process will perform that
tagging process for us.

### Creating a PR
When creating a PR for the upstream, you should branch off the `master` branch, so the PR
can be cleanly applied to the upstream repo.  Once you've finished with the PR changes, create
a PR against the upstream repo and our own `pureport/develop` branch.

On the CLI, this process looks like:
```shell script
git clone https://github.com/pureport/openstack4j.git
cd openstack4j
git checkout -b feature/foobar origin/master
# Some changes here
git push -u origin feature/foobar
```

Then create the two PR's.

#### Testing with a PR
Understandably, it may be hard to test these changes without first applying them to our own branch.  If you instead
wish to try the changes out locally against `pureport/develop`, create a feature branch off `pureport/develop` and build
your changes locally for testing.  Once you are done validating that the changes work, you can rebase the changes 
against `master` to get a clean PR or you can cherry pick the commits on a feature branch which would be to be applied to 
`master`.  

Once you're done, you would create the two PRs.
